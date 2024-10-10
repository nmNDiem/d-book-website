import { fetchUtils } from 'react-admin';

const apiUrl = 'http://localhost:8080/dbook/';
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
    },
    create: (resource, params) => {
        return httpClient(`${apiUrl}/${resource}`, {
            method: 'POST',
            body: JSON.stringify(params.data),
        }).then(({ json }) => ({
            data: { ...json, id: json.id },
        }));
    },
    update: (resource, params) => {
        return httpClient(`${apiUrl}/${resource}/${params.id}`, {
            method: 'PUT',
            body: JSON.stringify(params.data),
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
