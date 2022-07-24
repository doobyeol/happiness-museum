// const { defineConfig } = require('@vue/cli-service');
// module.exports = defineConfig({
// 	transpileDependencies: true,
// 	devServer: {
// 		disableHostCheck: true,
// 		port: 8080,
// 		proxy: {
// 			'/api': {
// 				target: 'http://localhost:9090/',
// 				changeOrigin: true,
// 			},
// 		},
// 	},
// });
module.exports = {
	devServer: {
		proxy: {
			'/api': {
				target: 'http://localhost:9090',
			},
		},
	},
};
