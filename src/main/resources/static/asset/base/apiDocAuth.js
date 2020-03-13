new Vue({
    el: '#container',
    data: function () {
        let validation = (rule, value, callback) => {

            if(value === ''){
                callback(new Error(rule.field+" required"))
            }
            if(value.length<5||value.length>13){
                callback(new Error(" the length of "+rule.field+" should be between 5 to 13 digits" ))
            }
        };
        return{
            authForm:{
                username:"",
                password:""
            },

            rules: {
                username: [
                    { validator:validation, trigger: 'blur' },
                ],
                password:[
                    { validator:validation, trigger: 'blur' },
                ]
            }
        }
    },
    methods:{
        showLog:function () {
            console.log(1230);
        },
        validateUsername:function(){},
        submitFrom:function () {
            let _this=this;
            console.log(_this.authForm);
            axios.post("/custodian-auth",_this.authForm).then(res=>{
                console.log(res)
            }).catch(err=>{
                console.log(err);
                _this.$message.error('Authentication Failed !!')
            })
        }
    },
    mounted:function () {
        console.log(123);
    }
})