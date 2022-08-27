<template>
	<v-container>
		<v-row ref="diaryContainer">
			<v-col
				cols="12"
				lg="3"
				md="4"
				sm="6"
				v-for="item in diaryList"
				:key="item.diaryNo"
			>
				<v-card rounded="lg" elevation="3">
					<v-img src="@/assets/withLeaf.png" height=""></v-img>
					<v-card-title> {{ item.title }} </v-card-title>
					<v-card-subtitle> {{ item.updateDt }} </v-card-subtitle>
				</v-card>
			</v-col>
		</v-row>
	</v-container>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';

export default {
	name: 'DiaryView',
	components: {},
	data() {
		return {
			pageParam: {
				page: 0,
				size: 10,
				sort: 'create_dt,desc',
			},
		};
	},
	computed: {
		...mapGetters({
			diaryList: 'diary/getDiaryList',
			last: 'diary/isLast',
		}),
	},
	created() {
		this.fetchDiaryList(this.pageParam);
		// window.addEventListener('scroll', this.scroll);
	},

	mounted() {
		console.log('window : ', window);
		window.onscroll = () => {
			this.scroll();
		};
	},

	methods: {
		...mapActions({
			fetchDiaryList: 'diary/fetchDiaryList',
		}),

		fetchNextPage() {
			console.log('##### fetchNextPage');
			if (this.last) {
				return;
			}
			this.pageParam.page++;
			this.fetchDiaryList(this.pageParam);
		},
		scroll() {
			console.log('############################################');
			console.log('####### window.pageYOffset', window.pageYOffset);
			console.log('####### scrollTop', document.documentElement.scrollTop);
			console.log('####### document.body.scrollTop', document.body.scrollTop);
			console.log(
				'####### diaryContainer',
				this.$refs.diaryContainer.offsetHeight,
			);
			// const maxScrollTop = Math.max(
			// 	window.pageYOffset,
			// 	document.documentElement.scrollTop,
			// 	document.body.scrollTop,
			// );
			const offsetHeight = document.documentElement.offsetHeight;

			// console.log('##### maxScrollTop ', maxScrollTop);
			console.log('##### offsetHeight ', offsetHeight);
			// let bottomOfWindow = maxScrollTop + window.innerHeight === offsetHeight;
			// let bottomOfWindow =
			// 	offsetHeight - this.$refs.diaryContainer.offsetHeight >= 64;

			// if (bottomOfWindow) {
			// 	console.log('################## fetchNextPage');
			// 	this.fetchNextPage();
			// }
		},
	},
};
</script>

<style></style>
