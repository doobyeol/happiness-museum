<template>
	<v-container class="mt-6">
		상세보기 페이지
		<h1 v-if="isWrite">isWrite</h1>
		<h1 v-if="isRead">isRead</h1>
		<h1 v-if="isModify">isModify</h1>
	</v-container>
</template>

<script>
export default {
	props: {
		isRead: {
			type: Boolean,
			default: false,
			require: false,
		},
		isWrite: {
			type: Boolean,
			default: false,
			require: false,
		},
		isModify: {
			type: Boolean,
			default: false,
			require: false,
		},
	},
	// data() {
	// 	return {
	// 		key: value,
	// 	};
	// },
	// created() {},
};
</script>

<style></style>
