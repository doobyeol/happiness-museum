<template>
	<div class="text-center">
		<v-overlay :absolute="false" v-model="loading.show" z-index="100">
			<v-progress-circular
				:size="50"
				color="amber"
				indeterminate
				class="mx-auto"
			></v-progress-circular>
		</v-overlay>
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
