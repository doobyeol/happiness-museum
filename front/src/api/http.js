// import Vue from 'vue';
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

function getConfig(params) {
	const authorization = getAuthorization();
	let config = {
		headers: {
			Authorization: authorization ? authorization : '',
		},
	};
	if (params) {
		config.params = params;
	}
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

export default {
	async get(url, params) {
		// const urlWithParams = url + '?' + Vue._.toQuery(params);
		try {
			const response = await axios.get(url, getConfig(params));
			return handleResponse(response);
		} catch (error) {
			return handleResponse(error);
		}
	},
	async post(url, params) {
		try {
			const response = await axios.post(url, params, getConfig());
			return handleResponse(response);
		} catch (error) {
			console.log(error);
			return handleResponse(error);
		}
	},
	async put(url, params) {
		try {
			const response = await axios.put(url, params, getConfig());
			return handleResponse(response);
		} catch (error) {
			console.log(error);
			return handleResponse(error);
		}
	},
	async delete(url, params) {
		try {
			const response = await axios.delete(url, getConfig(params));
			return handleResponse(response);
		} catch (error) {
			console.log(error);
			return handleResponse(error);
		}
	},
};
