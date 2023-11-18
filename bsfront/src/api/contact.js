import { request } from '../utils/request'

// 根据姓名查询联系人
export function selectContactByName(params) {
    return request({
        method: 'get',
        url: '/api/contact/selectContactByName/' + params.contactName,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据姓名删除联系人
export function deleteContactByName(params) {
    return request({
        method: 'delete',
        url: '/api/contact/deleteContactByName/' + params.contactName,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 根据姓名修改联系人信息
export function updateContatcByName(params) {
    return request({
        method: 'put',
        url: '/api/contact/updateContactByName/' + params.contactName,
        data: params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 查询所有用户
export function selectAllContact(params) {
    return request({
        method: 'get',
        url: '/api/contact/selectAll',
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}

// 新增用户
export function addContact(params) {
    return request({
        method: 'post',
        url: '/api/contact/addContact',
        data:params,
        headers: {
            'Authorization': window.localStorage.token,
        },
    })
}