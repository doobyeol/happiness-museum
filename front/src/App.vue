<template>
	<v-app id="app">
		<HmHeader></HmHeader>
		<router-view class="" />
	</v-app>
</template>

<script>
import HmHeader from '@/components/common/HmHeader.vue';

export default {
	name: 'HelloWorld',
	components: {
		HmHeader,
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
	padding-top: 64px !important;
}
</style>
