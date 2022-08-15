import http from '@/api/http';

export default {
	namespaced: true,

	state: () => ({
		userId: '',
		userNm: '',
		userMail: '',
		roles: [],
		token: '',
		refreshToken: '',
	}),

	getters: {
		getToken(state) {
			return state.token;
		},
	},

	mutations: {
		setLoginInfo(state, userInfo) {
			state.userId = userInfo.userId;
			state.userNm = userInfo.userNm;
			state.userMail = userInfo.userMail;
			state.roles = userInfo.roles;
			state.token = userInfo.token;
			state.refreshToken = userInfo.refreshToken;
		},
		setTokenAndRefreshToken(state, tokenInfo) {
			state.token = tokenInfo.token;
			state.refreshToken = tokenInfo.refreshToken;
		},
	},

	actions: {
		async login({ commit }, payload) {
			const data = await http.post('/api/auth/login', payload);
			if (data) {
				commit('setLoginInfo', data);
				return true;
			} else {
				return false;
			}
		},
		async refreshToken({ state, commit }) {
			const data = await http.post('/api/auth/token/refresh', {
				refreshToken: state.refreshToken,
			});
			if (data) {
				commit('setTokenAndRefreshToken', data);
				return true;
			} else {
				return false;
			}
		},
	},
};
