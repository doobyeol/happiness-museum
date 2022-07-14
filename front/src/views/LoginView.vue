<template>
	<v-container>
		<v-row>
			<v-col cols="12">
				<p class="font-weight-bold text-center text-h5">로그인</p>
			</v-col>
		</v-row>
		<v-row class="pa-5">
			<v-col class="mx-auto" cols="12" lg="4" md="6">
				<v-card class="pa-10">
					<v-form ref="form" @submit.prevent="submit">
						<v-text-field
							v-model="form.id"
							color="amber darken-1"
							label="아이디"
							required
							outlined
							dense
						/>
						<v-text-field
							v-model="form.password"
							color="amber darken-1"
							label="비밀번호"
							required
							outlined
							dense
						/>

						<v-btn color="amber darken-1" dark width="100%" elevation="0">
							로그인
						</v-btn>
					</v-form>
				</v-card>
			</v-col>
		</v-row>
	</v-container>
</template>

<script>
export default {
	name: 'LoginView',
	components: {},
	data() {
		return {
			form: {
				id: '',
				password: '',
			},
		};
	},
	methods: {},
};
</script>

<style></style>
