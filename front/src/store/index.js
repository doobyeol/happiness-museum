import Vue from 'vue';
import Vuex from 'vuex';
import common from './common';
import auth from './auth';
import user from './user';
import diary from './diary';

Vue.use(Vuex);

export default new Vuex.Store({
	state: {},
	getters: {},
	mutations: {},
	actions: {},
	modules: {
		common,
		auth,
		user,
		diary,
	},
});
