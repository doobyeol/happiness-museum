import http from '@/api/http';

export default {
	namespaced: true,

	state: () => ({
		diaryList: [],
		last: false,
	}),

	getters: {
		getDiaryList(state) {
			return state.diaryList;
		},
		isLast(state) {
			return state.last;
		},
	},

	mutations: {
		setDiaryList(state, diaryList) {
			state.diaryList = diaryList;
		},
		setLast(state, last) {
			state.last = last;
		},
	},

	actions: {
		async fetchDiaryList({ commit }, param) {
			const data = await http.get('/api/diary/list', param);
			commit('setDiaryList', data.content);
			commit('setLast', data.last);
		},
	},
};
