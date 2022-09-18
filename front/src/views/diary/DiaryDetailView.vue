<template>
	<v-container class="mt-6">
		<v-form ref="form" v-model="ui.validForm" lazy-validation>
			<v-menu
				ref="datePickerMenu"
				v-model="ui.datePickerMenu"
				:close-on-content-click="false"
				:return-value.sync="form.targetDt"
				transition="scale-transition"
				offset-y
				min-width="auto"
			>
				<template v-slot:activator="{ on, attrs }">
					<v-text-field
						v-model="form.targetDt"
						label="날짜"
						prepend-icon="mdi-calendar"
						readonly
						v-bind="attrs"
						v-on="on"
					></v-text-field>
				</template>
				<v-date-picker v-model="form.targetDt" no-title scrollable>
					<v-spacer></v-spacer>
					<v-btn text color="primary" @click="ui.datePickerMenu = false">
						취소
					</v-btn>
					<v-btn
						text
						color="primary"
						@click="$refs.datePickerMenu.save(form.targetDt)"
					>
						확인
					</v-btn>
				</v-date-picker>
			</v-menu>
		</v-form>
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
	data() {
		return {
			ui: {
				datePickerMenu: false,
				validForm: false,
			},
			form: {
				targetDt: '',
			},
		};
	},
	created() {},
	methods: {},
};
</script>

<style></style>
