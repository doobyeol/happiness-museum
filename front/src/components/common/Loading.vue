<template>
	<div class="text-center">
		<v-dialog class="loading" v-model="loading.show" width="50">
			<v-progress-circular
				:size="50"
				color="amber"
				indeterminate
				class="mx-auto"
			></v-progress-circular>
		</v-dialog>
	</div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
	name: 'Loading',
	computed: {
		...mapGetters({
			loading: 'common/getLoading',
		}),
	},
};
</script>

<style>
/* .v-dialog {
	overflow: hidden !important;
	box-shadow: unset !important;
} */
</style>
