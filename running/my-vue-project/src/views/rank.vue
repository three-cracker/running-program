<template>
  <div style="width: 100%;height: 100%">
    <el-header style="height: 20%;width: 100%;padding: 0.8rem 1rem">
      <div style="text-align: left;font-size: 1rem;padding-bottom: 10px;font-weight: bold;">排行榜</div>
      <div style="text-align: left">更新时间：{{ currentDate }}</div>
    </el-header>
    <el-main style="height: 80%;width: 100%;padding: 0">
      <el-card shadow="never" style="border-bottom: #eee 2px solid">
        <div style="flex: 1;display: flex;flex-direction: column;font-size: 0.5rem;font-weight: bolder;color: #2eb1e8" class="text item">
          <div>我的</div>
          <div>成绩</div>
        </div>
        <div style="flex: 1;" class="text item">
          <img :src="user.imgSrc" alt="" style="width: 90%;height:90%;border-radius: 50%">
        </div>
        <div style="flex: 1;" class="text item">
          {{ user.username }}
        </div>
        <div style="flex: 1;color: #2eb1e8" class="text item">
           {{ user.rank }}
        </div>
        <div style="flex: 1;color: #2eb1e8"  class="text item">
           {{ user.score }}
        </div>
      </el-card>
      <template>
        <el-table
            :data="tableData"
            style="width: 100%;font-size: .5rem"
            height="250">
          <el-table-column
              fixed
              align="center"
              prop="rank"
              label="排名"
              width="150">
          </el-table-column>
          <el-table-column
              align="center"
              prop="name"
              label="姓名"
              width="120">
          </el-table-column>
          <el-table-column
              align="center"
              prop="score"
              label="积分"
              width="120">
          </el-table-column>
        </el-table>
      </template>
    </el-main>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "rank",
  data(){
    return{
      user:localStorage.getItem("current-user") ? JSON.parse(localStorage.getItem("current-user")) : {},
      currentDate:'',
      tableData:[
        {
          rank:1,
          name:'lily',
          score: 120
        }
      ]
    }
  },
  created() {
    this.getCurrentDate()
    this.getRank()
    this.isLogin()
  },
  methods:{
    getCurrentDate(){
      let nowDate = new Date()
      let date = {
        year: nowDate.getFullYear(),
        month: nowDate.getMonth() + 1,
        date: nowDate.getDate()
      }
      this.currentDate = date.year + '-' + date.month + '-' + date.date
    },
    getRank(){
      axios.get('http://localhost:8081/user/credit').then(res =>{
        if (res.data.code==1){

        }
        else{
          console.log(res.data)
        }
      }).catch(reason => {
        console.log(reason)
      })
    },
    isLogin(){
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
    },
  },
  mounted() {

  }
}
</script>

<style>
*{
  padding: 0;
  margin: 0;
}
.el-header{
  background-image: url("@/assets/rank_bg.jpg");
  background-position: center;
  background-size: cover;
}
.el-card__body{
  display: flex;
  padding:20px 20px;
}
.el-card__body div{
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 10px 10px 0 0;
  font-size: 0.6rem;
}
</style>