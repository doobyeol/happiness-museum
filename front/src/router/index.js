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
		meta: { requiredLogin: false },
	},
	{
		path: '/home',
		name: 'home',
		component: () => import('../views/HomeView.vue'),
		meta: { requiredLogin: true },
	},
	{
		path: '/diary',
		name: 'diary',
		component: () => import('../views/DiaryView.vue'),
		meta: { requiredLogin: true },
	},
	{
		path: '/join',
		name: 'join',
		component: () => import('../views/JoinView.vue'),
		meta: { requiredLogin: true },
	},
	{
		path: '/about',
		name: 'about',
		component: () => import('../views/AboutView.vue'),
		meta: { requiredLogin: true },
	},
];

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes,
});

router.beforeEach(async (to, from, next) => {
	setShowNavBar(to);

	if (to.meta.requiredLogin === false) {
		next();
		return;
	}

	if (store.getters['auth/isLoggedIn']) {
		next();
		return;
	} else {
		const token = getTokenInLocalStorage();

		if (token) {
			const result = await store.dispatch('auth/loadUserInfoByToken', token);
			if (result) {
				next();
			} else {
				next('/login');
			}
		} else {
			next('/login');
		}
	}
});

function setShowNavBar(to) {
	const toName = to.name;
	const showNavBar = toName !== 'login' && toName !== 'join';
	store.commit('common/setShowNavBar', showNavBar);
}

function getTokenInLocalStorage() {
	const token = localStorage.getItem('token');
	return token;
}

export default router;
