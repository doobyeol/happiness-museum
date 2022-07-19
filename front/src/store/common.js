export default {
	namespaced: true,

	state: () => ({
		showNavBar: false,
	}),

	getters: {
		getShowNavBar(state) {
			return state.showNavBar;
		},
	},

	mutations: {
		setShowNavBar(state, show) {
			state.showNavBar = show;
		},
	},

	actions: {},
};
