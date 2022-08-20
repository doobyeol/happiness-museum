import Vue from 'vue';
import Vuex from 'vuex';
import common from './common';
import auth from './auth';
import user from './user';

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
	},
});
