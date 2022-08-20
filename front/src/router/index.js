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
		meta: { checkToken: false },
	},
	{
		path: '/home',
		name: 'home',
		component: () => import('../views/HomeView.vue'),
		meta: { checkToken: true },
	},
	{
		path: '/diary',
		name: 'diary',
		component: () => import('../views/DiaryView.vue'),
		meta: { checkToken: true },
	},
	{
		path: '/join',
		name: 'join',
		component: () => import('../views/JoinView.vue'),
		meta: { checkToken: true },
	},
	{
		path: '/about',
		name: 'about',
		component: () => import('../views/AboutView.vue'),
		meta: { checkToken: true },
	},
];

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes,
});

router.beforeEach(async (to, from, next) => {
	if (to.meta.checkToken && store.getters['auth/isLoggedIn']) {
	}

	setShowNavBar(to);
	let token = store.getters['auth/getToken'];
	console.log(token);
	if (token) {
		next();
		return;
	}

	token = loadTokenLocalStorage();
	if (token) {
		const result = await store.dispatch('auth/getUserInfoByToken', token);
		if (result) {
			next();
		} else {
			next('/login');
		}
	} else {
		next('/login');
	}
});

function setShowNavBar(to) {
	const toName = to.name;
	const showNavBar = toName !== 'login' && toName !== 'join';
	store.commit('common/setShowNavBar', showNavBar);
}

function loadTokenLocalStorage() {
	const token = localStorage.getItem('token');
	return token;
}

export default router;
