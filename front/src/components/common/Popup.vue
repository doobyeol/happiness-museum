<template>
	<div class="text-center">
		<v-dialog v-model="popup.show" width="500">
			<v-card>
				<v-card-title class="text-h5">
					{{ popup.title }}
				</v-card-title>

				<v-card-text> {{ popup.body }} </v-card-text>

				<v-card-actions>
					<v-spacer></v-spacer>
					<v-btn
						v-if="popup.isConfirm"
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
	name: 'Popup',
	computed: {
		...mapGetters({
			popup: 'common/getPopup',
		}),
	},
	methods: {
		...mapMutations({
			closePopup: 'common/closePopup',
		}),

		handleOk() {
			if (this.popup.ok && typeof this.popup.ok === 'function') {
				this.popup.ok();
			}
			this.closePopup();
		},
		handleCancel() {
			if (this.popup.cancel && typeof this.popup.cancel === 'function') {
				this.popup.cancel();
			}
			this.closePopup();
		},
	},
};
</script>

<style></style>
