<template>
	<v-app id="app">
		<Loading></Loading>
		<Popup></Popup>
		<NavBar v-if="showNavBar"></NavBar>
		<router-view :class="{ 'mt-6': showNavBar }" />
	</v-app>
</template>

<script>
import NavBar from '@/components/common/NavBar.vue';
import Popup from '@/components/common/Popup.vue';
import Loading from '@/components/common/Loading.vue';
import { mapGetters } from 'vuex';

export default {
	name: 'HelloWorld',
	components: {
		NavBar,
		Popup,
		Loading,
	},
	computed: {
		...mapGetters({
			showNavBar: 'common/getShowNavBar',
		}),
	},
};
</script>

<style lang="scss">
html {
	overflow-y: auto !important;
}

#app {
	font-family: Avenir, Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	// text-align: center;
	color: #2c3e50;
}

.container {
	height: calc(100vh - 64px) !important;
	padding-top: 64px !important;
}
</style>
