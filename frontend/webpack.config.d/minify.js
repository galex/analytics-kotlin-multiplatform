if (defined.PRODUCTION) {

    const UglifyJsPlugin = require("uglifyjs-3-webpack-plugin");

    config.plugins.push(new UglifyJsPlugin({
            uglifyOptions: {
                warnings: false,
                ie8: false,
                output: {
                    comments: false
                }
            }
        })
    );
}