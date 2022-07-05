<template>
	<div>
		<v-app-bar color="amber" dark>
			<v-toolbar-title>행복박물관</v-toolbar-title>
			<v-toolbar-items class="hidden-sm-and-down ml-auto">
				<v-btn v-for="item in menu" :key="item.title" :to="item.link" text>
					{{ item.title }}
				</v-btn>
			</v-toolbar-items>
			<v-app-bar-nav-icon
				class="ml-auto hidden-md-and-up"
				@click="drawer = true"
			></v-app-bar-nav-icon>
		</v-app-bar>

		<v-navigation-drawer
			v-model="drawer"
			absolute
			temporary
			right
			color="amber accent-4"
			dark
		>
			<v-list nav dense>
				<v-list-item-group
					v-model="group"
					active-class="brown--text text--accent-4"
				>
					<v-list-item v-for="item in menu" :key="item.title">
						<v-list-item-icon>
							<v-icon>{{ item.icon }}</v-icon>
						</v-list-item-icon>
						<v-list-item-title>{{ item.title }}</v-list-item-title>
					</v-list-item>
				</v-list-item-group>
			</v-list>
		</v-navigation-drawer>
	</div>
</template>

<script>
export default {
	name: 'HmHeader',
	props: {
		msg: String,
	},
	data() {
		return {
			menu: [
				{ icon: 'mdi-home', title: '홈' },
				{ icon: 'mdi-bank', title: '박물관 소개' },
				{ icon: 'mdi-flower', title: '행복 전시' },
				{ icon: 'mdi-bookmark', title: '소장품' },
			],
			drawer: false,
			group: null,
		};
	},

	methods: {
		menuItems() {
			return this.menu;
		},
	},

	watch: {
		group() {
			this.drawer = false;
		},
	},
};
</script>

<style>
.v-application--wrap {
	overflow-x: hidden !important;
}
</style>
