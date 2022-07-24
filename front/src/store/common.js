export default {
	namespaced: true,

	state: () => ({
		showNavBar: false,
		popup: {
			show: false,
			title: '',
			body: '',
			isConfirm: false,
			ok: null,
			cancel: null,
		},
	}),

	getters: {
		getShowNavBar(state) {
			return state.showNavBar;
		},
		getPopUp(state) {
			return state.popup;
		},
	},

	mutations: {
		setShowNavBar(state, show) {
			state.showNavBar = show;
		},
		closePopUp(state) {
			state.popup.show = false;
		},
		openPopUp(state, popUp) {
			state.popup = {
				show: true,
				title: popUp.title,
				body: popUp.body,
				type: popUp.type,
				isConfirm: popUp.isConfirm,
				ok: popUp.ok,
				cancel: popUp.cancel,
			};
		},
	},

	actions: {},
};
