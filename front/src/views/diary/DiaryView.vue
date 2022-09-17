<template>
	<v-container class="mt-6" ref="diaryContainer">
		<v-row>
			<v-col class="d-flex flex-row-reverse" cols="12">
				<v-fab-transition>
					<v-btn
						class="mx-2"
						color="amber darken-1"
						dark
						fab
						fixed
						bottom
						right
						@click="handleWriteDiary"
					>
						<v-icon> mdi-pencil </v-icon>
					</v-btn>
				</v-fab-transition>
			</v-col>
		</v-row>
		<v-row>
			<v-col
				cols="12"
				lg="4"
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
import { mapGetters, mapMutations, mapActions } from 'vuex';

export default {
	name: 'DiaryView',
	components: {},
	data() {
		return {
			pageParam: {
				page: 0,
				size: 12,
				sort: 'create_dt,desc',
			},
			scrollHandler: null,
		};
	},
	computed: {
		...mapGetters({
			diaryList: 'diary/getDiaryList',
			last: 'diary/isLast',
		}),
	},
	created() {
		this.clearDiaryList();
		this.fetchDiaryList(this.pageParam);
	},

	mounted() {
		this.scrollHandler = this._.debounce(this.handleScroll, 300);
		window.addEventListener('scroll', this.scrollHandler);
	},

	destroyed() {
		window.removeEventListener('scroll', this.scrollHandler);
	},

	methods: {
		...mapActions({
			fetchDiaryList: 'diary/fetchDiaryList',
		}),
		...mapMutations({
			clearDiaryList: 'diary/clearDiaryList',
		}),

		fetchNextPage() {
			if (this.last) {
				return;
			}
			this.pageParam.page++;
			this.fetchDiaryList(this.pageParam);
		},

		handleScroll() {
			let el = this.$refs.diaryContainer;
			const isBottom =
				el.scrollHeight - el.offsetHeight <= window.pageYOffset + 100;
			if (isBottom) {
				this.fetchNextPage();
			}
		},

		handleWriteDiary() {
			this.$router.push({
				name: 'diaryDetail',
				params: { isWrite: true },
			});
		},
	},
};
</script>

<style></style>
