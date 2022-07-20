import Vue from 'vue';
import VueRouter from 'vue-router';
import store from '../store';

Vue.use(VueRouter);

const routes = [
	{
		path: '/',
		alias: ['/', '/login'],
		name: 'login',
		component: () => import('../views/LoginView.vue'),
	},
	{
		path: '/home',
		name: 'home',
		component: () => import('../views/HomeView.vue'),
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
	{
		path: '/about',
		name: 'about',
		component: () => import('../views/AboutView.vue'),
	},
];

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes,
});

router.beforeEach((to, from, next) => {
	setShowNavBar(to);
	next();
});

function setShowNavBar(to) {
	const toName = to.name;
	const showNavBar = toName !== 'login' && toName !== 'join';
	store.commit('common/setShowNavBar', showNavBar);
}

export default router;
