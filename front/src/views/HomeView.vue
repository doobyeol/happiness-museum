<template>
	<div class="home">
		<!-- <img alt="Vue logo" src="../assets/logo.png" /> -->
		<HelloLeaf />
		<!-- <HelloDiary /> -->
	</div>
</template>

<script>
// @ is an alias to /src
import HelloLeaf from '@/components/HelloLeaf.vue';
// import HelloDiary from '@/components/HelloDiary.vue';

export default {
	name: 'HomeView',
	components: {
		HelloLeaf,
		// HelloDiary,
	},
};
</script>
