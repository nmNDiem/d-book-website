import { fetchUtils } from 'react-admin';

const apiUrl = 'http://localhost:8080/dbook';
const httpClient = (url, options = {}) => {
    options.headers = new Headers({ Accept: 'application/json' });
    return fetchUtils.fetchJson(url, options);
};

const dataProvider = {
    getList: (resource, params) => {
        const url = `${apiUrl}/${resource}`;
        return httpClient(url).then(({ json }) => ({
            data: json,
            total: json.length,
        }));
    },
    getOne: (resource, params) => {
        const url = `${apiUrl}/${resource}/${params.id}`;
        return httpClient(url).then(({ json }) => ({
            data: json,
        }));
    }, getMany: (resource, params) => {
        const query = {
            filter: JSON.stringify({ id: params.ids }),
        };
        const url = `${apiUrl}/${resource}?${fetchUtils.queryParameters(query)}`;
        return httpClient(url).then(({ json }) => ({
            data: json,
        }));
    },
    create: (resource, params) => {
        const formData = new FormData();
    
        // Thêm thông tin sách vào FormData
        Object.keys(params.data).forEach(key => {
            if (key !== 'image') {  // ảnh được xử lý riêng
                formData.append(key, params.data[key]);
            }
        });
    
        // Thêm file ảnh vào FormData (nếu có)
        if (params.data.image && params.data.image.rawFile) {
            formData.append('file', params.data.image.rawFile); // 'file' là tên dùng để upload ở backend
        }
    
        return httpClient(`${apiUrl}/${resource}`, {
            method: 'POST',
            body: formData, // Gửi dưới dạng multipart/form-data
        }).then(({ json }) => ({
            data: { ...json, id: json.id },
        }));
    },    
    update: (resource, params) => {
        const formData = new FormData();
    
        Object.keys(params.data).forEach(key => {
            if (key !== 'image') {
                formData.append(key, params.data[key]);
            }
        });
    
        if (params.data.image && params.data.image.rawFile) {
            formData.append('file', params.data.image.rawFile);
        }
    
        return httpClient(`${apiUrl}/${resource}/${params.id}`, {
            method: 'PUT',
            body: formData,
        }).then(({ json }) => ({
            data: json,
        }));
    },    
    delete: (resource, params) => {
        return httpClient(`${apiUrl}/${resource}/${params.id}`, {
            method: 'DELETE',
        }).then(() => ({
            data: { id: params.id },
        }));
    },
};

export default dataProvider;
