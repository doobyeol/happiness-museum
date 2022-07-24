import Vue from 'vue';
import axios from 'axios';
import store from '../store';

function getAuthorization() {
	const token = store.getters['auth/token'];
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
			Authorization: authorization ? authorization : '',
		},
	};
	return config;
}

function handleError() {}
function handleBizError() {}
function handleUnauthorized() {}
function handleForbidden() {}
function handleResponse(response) {
	if (response.status == 200) {
		if (response.data.resultCode != '0000') {
			handleBizError();
		} else {
			return response.data.data ? response.data.data : true;
		}
	} else if (response.status == 401) {
		handleUnauthorized();
	} else if (response.status == 403) {
		handleForbidden();
	} else {
		handleError();
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
		return handleResponse(error);
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
