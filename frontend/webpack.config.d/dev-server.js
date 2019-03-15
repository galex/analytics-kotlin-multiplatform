config.devServer = {
    hot: true,
    compress: true,
    watchContentBase: true,
    historyApiFallback: true,
    proxy: {
        '/api': 'http://localhost:8000/'
    },
};