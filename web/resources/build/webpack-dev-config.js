var path = require('path');
var htmlWebpackPlugin= require('html-webpack-plugin');

module.exports = {
	entry:'./src/main.js',
	output:{
		path:path.resolve(__dirname, '../dist/static/'),
		filename:'app.js'
	},
	resolve: {
		extensions: ['.js', '.vue'],
		alias:{
			'vue': 'vue/dist/vue.js'
		}
	},
	module:{
		loaders:[
			{
				test:/\.js$/,
				loader:'babel-loader',
				include:path.resolve(__dirname, 'src/'),
				query:{
					presets:['latest']
				}
			},
			{
				test:/\.css$/,
				loader:'style-loader!css-loader'
			},
			{
				test:/\.vue$/,
				loader:'vue-loader'
			},
			{
				test: /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
				loader: 'url-loader'
			}
		]
	},
	plugins:[
		new htmlWebpackPlugin({
			template:'../index.html',
			filename:'index.html'
		})
	]
	
}