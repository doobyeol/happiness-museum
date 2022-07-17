<template>
	<v-container>
		<v-row>
			<v-col cols="12">
				<p class="font-weight-bold text-center text-h5">회원가입</p>
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
						<v-text-field
							v-model="form.passwordCheck"
							color="amber darken-1"
							label="비밀번호 확인"
							required
							outlined
							dense
						/>
						<v-text-field
							v-model="form.name"
							color="amber darken-1"
							label="이름"
							required
							outlined
							dense
						/>
						<v-text-field
							v-model="form.tell"
							color="amber darken-1"
							label="연락처"
							required
							outlined
							dense
						/>
						<v-text-field
							v-model="form.email"
							color="amber darken-1"
							label="이메일"
							required
							outlined
							dense
						/>
						<v-text-field
							v-model="form.birth"
							color="amber darken-1"
							label="생년월일"
							required
							outlined
							dense
						/>
						<v-text-field
							v-model="form.happiness"
							color="amber darken-1"
							label="행복이란?"
							required
							outlined
							dense
						/>
						<v-text-field
							v-model="form.inviteCode"
							color="amber darken-1"
							label="초대코드"
							required
							outlined
							dense
						/>
						<v-btn color="amber darken-1" dark width="100%" elevation="0">
							회원가입
						</v-btn>
					</v-form>
				</v-card>
			</v-col>
		</v-row>
	</v-container>
</template>

<script>
export default {
	name: 'JoinView',
	components: {},
	data() {
		return {
			form: {
				id: '',
				password: '',
				passwordCheck: '',
				name: '',
				tell: '',
				email: '',
				birth: '',
				happiness: '',
				inviteCode: '',
			},
		};
	},
	methods: {},
};
</script>

<style></style>
