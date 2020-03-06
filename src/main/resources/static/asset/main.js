
const __ROOT__ = new Vue({
    el: '#container',
    data: function () {
        return{
            model:{}
        }
    },
    methods:{
        showLog:function () {
            console.log(1230);
        }
    },
    mounted:function () {
        console.log(123);
    }
});