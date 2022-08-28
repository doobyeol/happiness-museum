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
		appendDiaryList(state, diaryList) {
			state.diaryList = [...state.diaryList, ...diaryList];
		},
		setLast(state, last) {
			state.last = last;
		},
		clearDiaryList(state) {
			state.diaryList = [];
		},
	},

	actions: {
		async fetchDiaryList({ commit }, param) {
			const data = await http.get('/api/diary/list', param);
			commit('appendDiaryList', data.content);
			commit('setLast', data.last);
		},
	},
};
