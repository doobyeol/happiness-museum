import Vue from 'vue';
import App from './App.vue';
import './registerServiceWorker';
import router from './router';
import store from './store';
import vuetify from '@/plugins/vuetify';
import vueDragResize from 'vue-drag-resize';
import common from '@/plugins/common';

Vue.config.productionTip = false;
Vue.component('vue-drag-resize', vueDragResize);

new Vue({
	router,
	store,
	vuetify,
	common,
	render: h => h(App),
}).$mount('#app');
