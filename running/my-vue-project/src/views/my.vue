<template>
  <div>
    <div style="height: 20vh;display: flex;align-items: center;justify-content: center;flex-direction: column" class="container">
      <div style="font-size: 20px;margin:20px 0">我的</div>
      <div v-if="Object.keys(user).length === 0" >
        <button style="padding: 8px 25px;margin-bottom:15px;border-radius: 3px;background-color: transparent;color: #e7e5e5;border: 1px solid #eee" @click="$router.push('/login')">立即登录</button>
        <div style="font-size: 14px;color: #e7e5e5">你还未登录，请立即登录</div>
      </div>
      <div v-else>
        <img :src="user.imgSrc" alt="" style="width: 100px;height: 100px;border-radius: 50%">
      </div>
    </div>
    <div>
      <el-card class="box-card">
        <div class="text item">
            <i class="el-icon-medal" style="padding-right: 5px;"></i><span>我的积分</span>
            <span style="float: right;color: #b1b1b1">20分</span>
        </div>
      </el-card>
      <el-card class="box-card">
        <div class="text item"  @click="linkToActivity">
          <i class="el-icon-s-flag" style="padding-right: 5px;"></i><span>我的活动</span>
          <span style="float: right; "><i class="el-icon-arrow-right"></i></span>
        </div>
      </el-card>
      <el-card class="box-card">
        <div class="text item">
          <i class="el-icon-message-solid" style="padding-right: 5px;"></i><span>我的消息</span>
          <span style="float: right; "><i class="el-icon-arrow-right"></i></span>
        </div>
      </el-card>
      <el-card class="box-card">
        <div class="text item">
          <i class="el-icon-s-custom" style="padding-right: 5px;"></i><span>个人信息</span>
          <span style="float: right; "><i class="el-icon-arrow-right"></i></span>
        </div>
      </el-card>

      <el-card class="box-card">
        <div class="text item">
          <i class="el-icon-unlock" style="padding-right: 5px;"></i><span>修改密码</span>
          <span style="float: right; "><i class="el-icon-arrow-right"></i></span>
        </div>
      </el-card>
      <el-card class="box-card">
        <button style="color: red;border: none;background-color: transparent;width: 100%;height: 100%;font-size: 20px" @click="loginOut">退出登录</button>
      </el-card>
    </div>
    <div>

    </div>
  </div>
</template>

<script>
export default {
  name: "my",
  data(){
    return{
      user:localStorage.getItem("current-user") ? JSON.parse(localStorage.getItem("current-user")) : {},
    }
  },
  methods:{
    loginOut(){
      localStorage.removeItem("current-user");
      this.$router.push("/login")
    },
    linkToActivity(){
      if (Object.keys(this.user).length === 0){
        this.$confirm('还未登录，请立即登录', "提示", {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(()=>{
          this.$router.push('/login')
        }).catch(()=>{
          this.$message({
            type: 'info',
            message: '取消登录'
          });
        });
      }
      else{
        this.$router.push('/activity')
      }

    }
  }
}
</script>

<style scoped>
.container{
  background-image: url("@/assets/my_bg.jpg");
  background-position: center;
  background-size: cover;
}
.text {
  font-size: 20px;
}

.item {
  text-align: left;
  cursor: pointer;
}
.box-card {
  width: 100%;
  border-radius: 0;
}
</style>