<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="size">
      <el-input v-model="dataForm.size" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="unit">
      <el-input v-model="dataForm.unit" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="amount">
      <el-input v-model="dataForm.amount" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          donater: 0,
          name: '',
          size: '',
          unit: '',
          amount: ''
        },
        dataRule: {
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          size: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          unit: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          amount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.donater = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.donater) {
            this.$http({
              url: this.$http.adornUrl(`/renren/donation2/info/${this.dataForm.donater}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.donation2.name
                this.dataForm.size = data.donation2.size
                this.dataForm.unit = data.donation2.unit
                this.dataForm.amount = data.donation2.amount
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/renren/donation2/${!this.dataForm.donater ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'donater': this.dataForm.donater || undefined,
                'name': this.dataForm.name,
                'size': this.dataForm.size,
                'unit': this.dataForm.unit,
                'amount': this.dataForm.amount
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
