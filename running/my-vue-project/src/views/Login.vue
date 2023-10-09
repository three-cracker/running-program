<template>
  <!-- <h2>你好</h2> -->
  <div class="login_container" style="width:100vw;height:100vh;display: flex;align-items: center;justify-content: center;">
    <div class="login_box" style="width: 7rem">
      <!-- 头像区 -->
      <div class="avatar_box" style="padding: 15px 0">
        <img src="@/assets/logo2.png" style="width: 150px;height: 150px" >
      </div>
      <!-- 登陆表单区 -->
      <el-form ref="loginFormRef" label-width="0px" class="login_form" :model="user" :rules="rules">
        <!-- 用户名 -->
        <el-form-item label="" prop="username">
          <el-input prefix-icon="el-icon-user-solid" v-model="user.username" placeholder="用户名" style="box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)"></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item label="" prop="password">
          <el-input type="password" prefix-icon="el-icon-lock" v-model="user.password" placeholder="密码" style="box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)"></el-input>
          <div >没有账号？前往 <span style="color: #2eb1e8;cursor: pointer" @click="$router.push('/register')">注册</span></div>
        </el-form-item>
        <!-- 按钮区 -->
        <el-form-item label="" class="btns">
          <el-button type="primary" @click="login" style="box-shadow:0 2px 12px 0px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .4) !important;">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Login",
  data() {
    return {
      // 这是登录表单数据绑定对象
      user:{
        username:'',
        password:''
      },
      rules:{
        username:[
          {required:true,message:'请输入账号',trigger:'blur'},
        ],
        password: [
          {required:true,message:'请输入密码',trigger:'blur'},
        ]
      }
    }

  },
  methods: {
    // await 把函数修饰位异步函数只能用在 async 简化Promise
    login() {
      this.$refs.loginFormRef.validate(async valid => {
        // console.log(valid);
        if (valid){
          //   验证通过
          axios.post("http://localhost:8081/user/login",
              {
                username:this.user.username,
                password:this.user.password
              },
              {
                headers:{
                  'Content-Type':'application/json'
                }
              }).then(res =>{
            //   当后台返回的code是200的时候，表示验证通过
            //   这时候要存储用户信息，然后跳转到主页
            console.log(res.data)
            if (res.data.code === 1){
              this.$router.push('/home')
              this.$message.success('登录成功');
              localStorage.setItem('current-user',JSON.stringify(res.data.data)) //存储用户信息，使用json形式存储
            }
            else{
              this.$message.error(res.data.msg)
            }

          })
        }

      })
    },

  },
  mounted() {
    // 获取地理位置
    // var geolocation = new BMapGL.Geolocation();
    // geolocation.getCurrentPosition(function (r) {
    //   if (this.getStatus() == BMAP_STATUS_SUCCESS) {
    //     const province = r.address.province;
    //     const city = r.address.city;
    //     localStorage.setItem("location", province + city);
    //   }
    // });
    // 获取地理位置
    var geolocation = new BMapGL.Geolocation();
    geolocation.getCurrentPosition(function(r){
      if(this.getStatus() == BMAP_STATUS_SUCCESS){
        const province = r.address.province
        const city = r.address.city
        localStorage.setItem("location", province + city)
      }
    });
  },

}
</script>

<style scoped>
.login_container{
  background-image: url("@/assets/bg1.png");
  background-size: cover;
  background-position: center;
}
</style>