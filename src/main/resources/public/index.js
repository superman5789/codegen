// 加载数据
let app = new Vue({
    el: '#app',
    data() {
        return {
            configList: [{}],
            tableList: [],
            config: {},
            table: {}
        }
    },
    mounted() {
        this.getList()
    },
    filters:{
        getTablePrefix: function (tableName) {
            if(tableName && tableName.indexOf("_") != -1){
                return tableName.split('_')[0];
            }
            return "";
        },
        getTableSuffix: function (tableName) {
            if(tableName){
                var arr = tableName.split('_');
                //获取每个元素中的第一个字符，并转换为大写
                for(var i =0;i<arr.length;i++){
                    if(i==0){
                        arr[i] ='';
                    }else {
                        arr[i] = arr[i].charAt(0).toUpperCase()+arr[i].substr(1,arr[i].length-1)
                    }
                }
                //根据某个字符将数组转换为字符串
                return arr.join("");
            }
            return '';
        },
        getCommentPrefix: function (comment) {
            return comment && comment.split('表')[0];
        },
        getJson: function (obj) {
            return obj && JSON.stringify(obj);
        }
    },
    methods: {
        getList: function () {
            axios.get('generator/datasource/list')
                .then(response => {
                    app.configList = response.data.data
        }).catch(function (error) {
                console.log(error);
            });
        },
        getTableList: function (config) {
            axios.get('generator/datasource/table/list?dbName='+config.dbName)
                .then(response => {
                    app.config = config
                    app.tableList = response.data.data
        }).catch(function (error) {
                console.log(error);
            });
        },
        getTable: function (table) {
            app.table = table
        }



    }
})