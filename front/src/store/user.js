import http from '@/api/http';

export default {
	namespaced: true,

	state: () => ({
		happinessList: [],
	}),

	getters: {
		getHappinessList(state) {
			return state.happinessList;
		},
	},

	mutations: {
		setHappinessList(state, happinessList) {
			state.happinessList = happinessList;
		},
	},

	actions: {
		async fetchHappinessList({ commit }) {
			const data = await http.get('/api/user/happiness/list');
			commit('setHappinessList', data);
		},
	},
};
