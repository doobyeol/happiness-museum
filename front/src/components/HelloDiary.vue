<template>
	<v-container>
		<v-row>
			<v-col cols="12" lg="3" md="4" sm="6" v-for="index in 8" :key="index">
				<v-card rounded="lg" elevation="3">
					<v-img src="@/assets/withLeaf.png" height=""></v-img>
					<v-card-title> 나는 선생님이 좋아 </v-card-title>
					<v-card-subtitle> 2022.05.06 </v-card-subtitle>
				</v-card>
			</v-col>
		</v-row>
	</v-container>
</template>

<script>
export default {};
</script>

<style></style>
