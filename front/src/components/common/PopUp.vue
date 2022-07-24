<template>
	<div class="text-center">
		<v-dialog v-model="popUp.show" width="500">
			<v-card>
				<v-card-title class="text-h5">
					{{ popUp.title }}
				</v-card-title>

				<v-card-text> {{ popUp.body }} </v-card-text>

				<v-card-actions>
					<v-spacer></v-spacer>
					<v-btn
						v-if="popUp.isConfirm"
						color="grey darken-1"
						text
						@click="handleCancel"
					>
						취소
					</v-btn>
					<v-btn color="green darken-1" text @click="handleOk"> 확인 </v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>
	</div>
</template>

<script>
import { mapGetters, mapMutations } from 'vuex';

export default {
	name: 'PopUp',
	computed: {
		...mapGetters({
			popUp: 'common/getPopUp',
		}),
	},
	methods: {
		...mapMutations({
			closePopUp: 'common/closePopUp',
		}),

		handleOk() {
			if (this.popUp.ok && typeof this.popUp.ok === 'function') {
				this.popUp.ok();
			}
			this.closePopUp();
		},
		handleCancel() {
			if (this.popUp.cancel && typeof this.popUp.cancel === 'function') {
				this.popUp.cancel();
			}
			this.closePopUp();
		},
	},
};
</script>

<style></style>
