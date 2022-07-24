import Vue from 'vue';
import store from '@/store';

const myPopUp = {
	install(vue) {
		vue.prototype.$popUp = {
			open(popUpOptions) {
				store.commit('common/openPopUp', popUpOptions);
			},
			close() {
				store.commit('common/closePopUp');
			},
		};
	},
};

Vue.use(myPopUp);
