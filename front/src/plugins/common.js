import Vue from 'vue';
import store from '@/store';

const myPopup = {
	install(vue) {
		vue.prototype.$popup = {
			open(popupOptions) {
				store.commit('common/openPopup', popupOptions);
			},
			close() {
				store.commit('common/closePopup');
			},
			openLoading() {},
		};
		vue.showLoading = function () {
			store.commit('common/showLoading');
		};
		vue.prototype.$loading = {
			show() {
				store.commit('common/showLoading');
			},
			hide() {
				store.commit('common/hideLoading');
			},
			openLoading() {},
		};
	},
};

Vue.use(myPopup);
