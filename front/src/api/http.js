import Vue from 'vue';
import axios from 'axios';
import store from '../store';
import router from '../router';

function getAuthorization() {
	const token = store.getters['auth/getToken'];
	if (token) {
		return `Bearer ${token}`;
	} else {
		return '';
	}
}

function getConfig() {
	const authorization = getAuthorization();
	let config = {
		headers: {
			authorization: authorization ? authorization : '',
		},
	};
	return config;
}

function handleError(response) {
	Vue.prototype.$popup.open({
		title: '알림',
		body: `오류가 발생했습니다. 관리자에게 문의해주세요.(status: ${response.status}, code: ${response.data.resultCode}, message: ${response.data.resultMessage})`,
	});
}
function handleBizError(data) {
	Vue.prototype.$popup.open({
		title: '알림',
		body: `${data.resultMessage}[${data.resultCode}]`,
	});
}
async function handleUnauthorized(method, url, config) {
	if (url === '/api/auth/token/refresh') {
		Vue.prototype.$popup.open({
			title: '알림',
			body: `세션이 만료되었습니다. 다시 로그인해 주세요.`,
			ok: async () => {
				router.push('login');
			},
		});
	} else {
		const result = await store.dispatch('auth/refreshToken');
		if (result) {
			config.headers.authorization = getAuthorization();
			return await request(method, url, config);
		}
	}
}
function handleForbidden() {
	Vue.prototype.$popup.open({
		title: '알림',
		body: `접근 권한이 없습니다.`,
	});
}
function handleResponse(response) {
	if (response.status == 200) {
		if (response.data.resultCode != '0000') {
			handleBizError(response.data);
		} else {
			return response.data.data ? response.data.data : true;
		}
	} else if (response.status == 403) {
		handleForbidden();
	} else {
		handleError(response);
	}
	return false;
}

async function request(method, url, config) {
	config.url = url;
	config.method = method;
	try {
		Vue.prototype.$loading.show();
		const response = await axios.request(config);
		return handleResponse(response);
	} catch (error) {
		if (error.response.status === 401) {
			return handleUnauthorized(method, url, config);
		} else {
			return handleResponse(error.response);
		}
	} finally {
		Vue.prototype.$loading.hide();
	}
}

export default {
	async get(url, params) {
		// const urlWithParams = url + '?' + Vue._.toQuery(params);
		const config = getConfig();
		config.params = params;
		return await request('get', url, config);
	},
	async post(url, params) {
		const config = getConfig();
		config.data = params;
		return await request('post', url, config);
	},
	async put(url, params) {
		const config = getConfig();
		config.data = params;
		return await request('put', url, config);
	},
	async delete(url, params) {
		const config = getConfig();
		config.params = params;
		return await request('delete', url, config);
	},
};
