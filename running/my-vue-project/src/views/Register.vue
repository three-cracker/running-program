<template>
  <!-- <h2>你好</h2> -->
  <div class="login_container" style="width:100vw;height:100vh;display: flex;align-items: center;justify-content: center;">
    <div class="login_box" style="width: 7rem">
      <!-- 头像区 -->
      <div class="avatar_box" style="padding: 15px 0">
        <img src="@/assets/logo2.png" style="width: 150px;height: 150px" >
      </div>
      <!-- 登陆表单区 -->
      <el-form ref="registerFormRef" label-width="0px" class="login_form" :model="user" :rules="rules">
        <!-- 用户名 -->
        <el-form-item label="" prop="username">
          <el-input prefix-icon="el-icon-user-solid" v-model="user.username" placeholder="用户名" style="box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)"></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item label="" prop="password">
          <el-input type="password" prefix-icon="el-icon-lock" v-model="user.password" placeholder="密码" style="box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)"></el-input>
          <div >已有帐号？前往 <span style="color: #40a56c;cursor: pointer" @click="$router.push('/login')">登录</span></div>
        </el-form-item>
        <!-- 按钮区 -->
        <el-form-item label="" class="btns">
          <el-button type="primary" style="box-shadow:0 2px 12px 0px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .4) !important;background-color: #40a56c" @click="register">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
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
    register() {
      this.$refs.registerFormRef.validate(async valid => {
        // console.log(valid);
        if (!valid) return;
      })
    }
  }
}
</script>

<style scoped>
.login_container{
  background-image: url("@/assets/bg1.png");
  background-size: cover;
  background-position: center;
}
</style>