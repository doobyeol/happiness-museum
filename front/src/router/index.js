import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
	{
		path: '/',
		name: 'home',
		component: () => import('../views/HomeView.vue'),
	},
	{
		path: '/login',
		name: 'login',
		component: () => import('../views/LoginView.vue'),
	},
	{
		path: '/diary',
		name: 'diary',
		component: () => import('../views/DiaryView.vue'),
	},
	{
		path: '/join',
		name: 'join',
		component: () => import('../views/JoinView.vue'),
	},
];

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes,
});

export default router;
