<template>
	<v-app id="app">
		<NavBar></NavBar>
		<router-view class="mt-14" />
	</v-app>
</template>

<script>
import NavBar from '@/components/common/NavBar.vue';

export default {
	name: 'HelloWorld',
	components: {
		NavBar,
	},
	props: {
		msg: String,
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
