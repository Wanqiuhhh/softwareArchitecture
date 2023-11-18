<template>
    <div class="contact-manage">
    <h1 text-align="center">个人通讯录</h1>
    <el-button type="button" class="addButton" @click="addContact()">
      <span>新增</span>
    </el-button>
    <el-table
      ref="multipleTable"
      tooltip-effect="dark"
      style="width: 100%"
      :data="contactData">
      <el-table-column prop="contactName" label="姓名"></el-table-column>
      <el-table-column prop="address" label="地址" show-overflow-tooltip></el-table-column>
      <el-table-column prop="phoneNumber" label="电话"> </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <div>
            <el-button type="success" icon="el-icon-edit" circle
              @click="managerChangeInfo(scope.row.contactName)"></el-button>
            <el-button type="danger" icon="el-icon-delete" circle
              @click="deleteUserNameClick(scope.row.contactName)"></el-button>
            <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
              <span>确认删除该用户</span>
              <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="success" @click="managerDeleteUser(deleteContactName)">确 定</el-button>
              </span>
            </el-dialog>
          </div>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="用户信息" :visible.sync="dialogForm1Visible" class="change-contact-info">
      <el-form class="contact-info">
        <el-form-item label="姓名" :label-width="formLabelWidth" class="changeName">
          <el-input autocomplete="off" v-model="updateContactData.contactName"></el-input>
        </el-form-item>
        <el-form-item label="住址" :label-width="formLabelWidth" class="changeAddress">
          <el-input autocomplete="off" v-model="updateContactData.address"></el-input>
        </el-form-item>
        <el-form-item label="电话" :label-width="formLabelWidth" class="changePhoneNumber">
          <el-input autocomplete="off" v-model="updateContactData.phoneNumber"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogForm1Visible = false">取 消</el-button>
        <el-button type="success" @click="submitCHangeInfo">确 定</el-button>
      </div>
    </el-dialog>
    <el-dialog title="用户信息" :visible.sync="dialogForm2Visible" class="change-contact-info">
      <el-form class="contact-info">
        <el-form-item label="姓名" :label-width="formLabelWidth" class="changeName">
          <el-input autocomplete="off" v-model="addContactData.contactName"></el-input>
        </el-form-item>
        <el-form-item label="住址" :label-width="formLabelWidth" class="changeAddress">
          <el-input autocomplete="off" v-model="addContactData.address"></el-input>
        </el-form-item>
        <el-form-item label="电话" :label-width="formLabelWidth" class="changePhoneNumber">
          <el-input autocomplete="off" v-model="addContactData.phoneNumber"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogForm2Visible = false">取 消</el-button>
        <el-button type="success" @click="submitNewContact">确 定</el-button>
      </div>
    </el-dialog>
    </div>
</template>
<script>
import{
  selectContactByName,
  deleteContactByName,
  updateContatcByName,
  selectAllContact,
  addContact
}from "../api/contact";
export default{
  data(){
    return{
      contactData:[],
      dialogVisible:false,
      dialogForm1Visible:false,
      dialogForm2Visible:false,
      formLabelWidth: "120px",
      deleteContactName: "",
      updateContactData: {},
      addContactData:{
        contactName:"",
        address:"",
        phoneNumber:"",
      },
    }
  },
  methods:{
    managerChangeInfo(contactName) {
      this.dialogForm1Visible = true;
      selectContactByName({
        contactName: contactName,
      }).then((res) => {
        this.updateContactData = res.data;
      });
    },
    deleteUserNameClick(deleteContactName) {
      this.deleteContactName = deleteContactName;
      this.dialogVisible = true;
    },
    managerDeleteUser(contactName) {
      this.dialogVisible = false;
      deleteContactByName({
        contactName: contactName,
      }).then((res) => {
        if (res.flag == true) {
          alert(res.message);
          this.reload();
        } else {
          alert(res.data);
        }
      });
    },
    submitCHangeInfo() {
      this.dialogForm1Visible = false;
      updateContatcByName({
        contactName: this.updateContactData.contactName,
        phoneNumber: this.updateContactData.phoneNumber,
        address: this.updateContactData.address,
      }).then((res) => {
          if (res.flag == true) {
            alert(res.message);
            this.reload();
          } else {
            alert(res.data);
          }
        })
    },
    addContact(){
      this.dialogForm2Visible = true;
    },
    submitNewContact(){
      this.dialogForm2Visible = false;
      addContact({
        contactName: this.addContactData.contactName,
        phoneNumber: this.addContactData.phoneNumber,
        address: this.addContactData.address,
      }).then((res) => {
          if (res.flag == true) {
            alert(res.message);
          } else {
            alert(res.data);
          }
        })
    }
  },
  created() {
      selectAllContact({
      }).then((res) => {
        this.contactData = res.data;
      })
      .catch((err) => {
        console.log(err);
      });
  },
}
</script>
<style lang="less" scoped>
.contact-manage{
    width: 1100px;
    background: #fff;
    margin: 0 auto;
    padding: 0 20px;
    .addButton{
      display: flex;
      flex: left;
      margin-bottom: 10px;
      padding:7px,12px;
      color: #fff;
      border-color: #67C23A;
      background-color: #67C23A;
      border: 1px solid #DCDFE6;
      border-radius: 4px;
    }
    .change-contact-info{
    .el-dialog {
          width: 500px;
          .el-dialog__body {
            height: 400px;
            .contact-info {
              width: 400px;
              padding: 0;
              .changeName,
              .changeAddress,
              .changePhoneNumber {
                .el-form-item__label {
                  width: 100px !important;
                }
                width: 400px;
                margin-right: 200px;
              }
            }
          }
        }
}
}
</style>