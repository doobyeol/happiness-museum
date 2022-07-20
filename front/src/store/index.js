import Vue from 'vue';
import Vuex from 'vuex';
import common from './common';
import auth from './auth';

Vue.use(Vuex);

export default new Vuex.Store({
	state: {},
	getters: {},
	mutations: {},
	actions: {},
	modules: {
		common,
		auth,
	},
});
