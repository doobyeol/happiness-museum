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
							v-model="form.userId"
							color="amber darken-1"
							label="아이디"
							required
							outlined
							dense
							@keyup.enter="handleLogin"
						/>
						<v-text-field
							v-model="form.userPw"
							color="amber darken-1"
							label="비밀번호"
							:type="'password'"
							required
							outlined
							dense
							@keyup.enter="handleLogin"
						/>

						<v-btn
							color="amber darken-1"
							dark
							width="100%"
							elevation="0"
							@click="handleLogin"
							@keyup.enter="handleLogin"
						>
							로그인
						</v-btn>
					</v-form>
				</v-card>
			</v-col>
		</v-row>
	</v-container>
</template>

<script>
import { mapActions } from 'vuex';

export default {
	name: 'LoginView',
	components: {},
	data() {
		return {
			form: {
				userId: '',
				userPw: '',
			},
		};
	},
	methods: {
		...mapActions({
			login: 'auth/login',
		}),
		async handleLogin() {
			this.$popup.open({
				title: '팝업 테스트',
				body: '로그인 하시겠습니까?',
				ok: async () => {
					console.log('ok');
					const result = await this.login({
						userId: this.form.userId,
						userPw: this.form.userPw,
					});
					if (result) {
						this.$router.push('home');
					}
				},
				cancel: () => {
					console.log('cancel');
				},
			});
		},
	},
};
</script>

<style></style>
