<template>
	<div class="home">
		<!-- <img alt="Vue logo" src="../assets/logo.png" /> -->
		<HelloWorld />
		<HelloDiary />
	</div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloLeaf.vue';
import HelloDiary from '@/components/HelloDiary.vue';

export default {
	name: 'HomeView',
	components: {
		HelloWorld,
		HelloDiary,
	},
};
</script>
