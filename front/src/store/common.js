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
		loading: {
			show: false,
		},
	}),

	getters: {
		getShowNavBar(state) {
			return state.showNavBar;
		},
		getPopup(state) {
			return state.popup;
		},
		getLoading(state) {
			return state.loading;
		},
	},

	mutations: {
		setShowNavBar(state, show) {
			state.showNavBar = show;
		},
		closePopup(state) {
			state.popup.show = false;
		},
		openPopup(state, popup) {
			state.popup = {
				show: true,
				title: popup.title,
				body: popup.body,
				type: popup.type,
				isConfirm: popup.isConfirm,
				ok: popup.ok,
				cancel: popup.cancel,
			};
		},
		showLoading(state) {
			state.loading.show = true;
		},
		hideLoading(state) {
			state.loading.show = false;
		},
	},

	actions: {},
};
